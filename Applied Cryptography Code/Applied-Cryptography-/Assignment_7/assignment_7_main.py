from email.encoders import encode_noop
import encode

# Input for program
input = 0xADE1
# input = 0x2de1

print('Input is: ' + str(bin(input)) + '\n')

# Call function to create the first number
numOne = encode.createNumOne(input)

numberOne = encode.numConcat(numOne)

print('Binary value of First Number is: ' + str(bin(numberOne)) + '\n')
print('Hex value of First Number is: ' + str(hex(numberOne)) + '\n')
print('Decimal Value of First Number is: ' + str(numberOne) + '\n')

# Call function to create the second number
numTwo = encode.createNumTwo(input)

numberTwo = encode.numConcat(numTwo)

print('Binary value of Second Number is: ' + str(bin(numberTwo)) + '\n')
print('Hex value of Second Number is: ' + str(hex(numberTwo)) + '\n')
print('Decimal Value of Second Number is: ' + str(numberTwo) + '\n')

# Call function to add the two numbers together
finalNum = encode.addNums(numberOne, numberTwo)

print('Cipher is: (' + str(numberOne) + ', ' + str(numberTwo) + ')')
print('Encoded Value is: ' + str(hex(finalNum)))