# Must first import files
import string
import Test.class_testing as class_testing

# Then methods can be called -- Similar to Java
harry = class_testing.person()

print('Testing class method greet():')

harry.greet()

print('')

print('Testing class method addition():')

print(class_testing.addition())

print('')

print('Testing turning string to UPPERCASE:')

testStr = 'Hey'

print(testStr[2].upper())

print('')

print('Printing out all characters of a string:')

for i in testStr:
    currentChar = i
    if currentChar == 'e':
        continue # Like Break statement
    print(currentChar)
    
print('')

print('Testing hex() function:')

print('Hex value of 170 = ' + hex(170))

print(bin(0x00))