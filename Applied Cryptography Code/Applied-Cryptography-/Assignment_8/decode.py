# Breaks cipherOne(188) into 4 nibbles to be easily appended with cipherTwo(153)
def decodeNumOne(cipherOne):
    numberOne = []
    
    while cipherOne > 0:
        nibble = cipherOne & 0b11

        numberOne.append(nibble)
            
        cipherOne = cipherOne >> 2
    
    return numberOne

# Breaks cipherTwo(153) into 4 nibbles to be easily appended with cipherOne(188)
def decodeNumTwo(cipherTwo):
    numberTwo = []
    
    while cipherTwo > 0:
        nibble = cipherTwo & 0b11
        
        numberTwo.append(nibble)
        cipherTwo = cipherTwo >> 2
        
    return numberTwo

# Updated numConcat function to take arrays of 188 and 153 and concatenate them together piece by piece
# Combines the most significant bits and the least significant bits back together
def numConcat(num1, num2):
    first = num1[3]
    second = num1[2]
    third = num1[1]
    fourth = num1[0]

    one = num2[3]
    two = num2[2]
    three = num2[1]
    four = num2[0]
    
    number = (first << 2) | (one)
    number = (number << 2) | (second)
    number = (number << 2) | (two)
    number = (number << 2) | (third)
    number = (number << 2) | (three)
    number = (number << 2) | (fourth)
    number = (number << 2) | (four)
    return number