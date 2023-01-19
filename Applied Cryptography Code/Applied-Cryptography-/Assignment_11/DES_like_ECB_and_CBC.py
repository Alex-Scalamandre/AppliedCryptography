import DES_like

# Helper function for ECB and CBC
def createBitGroups(plainText):
    # Create list of hexadecimal representations of the ordinal values of chars 
    ordPlain = [hex(ord(c)) for c in plainText]
    
    # Combine the hex strings together and then remove the '0x'
    theString = ''.join(ordPlain)
    theString = theString.replace('0x', '')
    
    # Create a list of groups of 3 (12 bits) and convert them back to hex values
    # Help from: https://stackoverflow.com/questions/9475241/split-string-every-nth-character
    n = 3
    nibbles = [int(theString[i:i+n], 16) for i in range(0, len(theString), n)]
    return nibbles

def ECB(plainText, key):
    nibbles = createBitGroups(plainText)
    
    # Create a list of encrypted values
    encryptedList = [hex(DES_like.encrypt(c, key)) for c in nibbles]
    
    # Create final string and remove all 0x
    finalString = ''.join(encryptedList)
    finalString = finalString.replace('0x', '')

    # Print format and final string
    print('ECB: 0x' + finalString)
    
def CBC(plainText, key, IV):
    nibbles = createBitGroups(plainText)
    
    finalList = []
    
    # Encryption loop
    for i in range(len(nibbles)):
        # First iteration uses IV (Initialization Vector) instead of previous cipher text since there is none
        if i == 0:
            encrypted = DES_like.encrypt((nibbles[i] ^ IV), key)
            finalList.append(encrypted)
        # Encryption using previous cipher texts
        else:
            encrypted = DES_like.encrypt((nibbles[i] ^ finalList[i-1]), key)
            finalList.append(encrypted)
    
    # Formatting and printing
    hexList = [hex(c) for c in finalList]
    finalString = ''.join(hexList)
    finalString = finalString.replace('0x', '')
    print('CBC: 0x' + finalString)

if __name__=="__main__":
    plainText = "World!"
    key = 421
    IV = 124

    ECB(plainText, key)
    CBC(plainText, key, IV)
    
