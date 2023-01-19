# Function to create the first number of the Cipher
def createNumOne(value):
    numOne = []
    
    # Loop to create a nibble and then append the two most significant bits of the nibble to a list.
    while value > 0:
        nibble = value & 0xF
        # print(bin(nibble))
        value = value >> 4
        
        numOne.append(nibble >> 2)
    
    return numOne

# Function to create the second number of the Cipher
def createNumTwo(value):
    numTwo = []
    
    # Loop to create a nibble and then append the two least significant bits of the nibble to a list.
    while value > 0:
        nibble = value & 0xF
        value = value >> 4
        
        numTwo.append(nibble & 0b0011)
        
    return numTwo
        
# Function to concatenate the two numbers to create the encoded hex value.
def addNums(numOne, numTwo):
    shiftAmount = len(str(bin(numTwo))) - 2 # -2 is for the 0b at the front of the string.
    
    # I could hard code shift amount to be 8 as well.
    finalNum = (numOne << shiftAmount) | (numTwo)
    return finalNum

# Function to concatenate bits
def numConcat(num):
    first = num[3]
    second = num[2]
    third = num[1]
    fourth = num[0]
    
    number = (first << 2) | (second)
    number = (number << 2) | (third)
    number = (number << 2) | (fourth)
    return number
    
    