import decode

cipherOne = 188
cipherTwo = 153

print('Input is: (' + str(cipherOne) + ', ' + str(cipherTwo) + ')\n')

# Decode the first number
numOne = decode.decodeNumOne(cipherOne)  

# Decode the second number
numTwo = decode.decodeNumTwo(cipherTwo)

# Concatenate the two numbers together to form plaintext
finalNum = decode.numConcat(numOne, numTwo)


print('The original plaintext is: ' + str(hex(finalNum)))