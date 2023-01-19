import RC4

key = 'Key'
plainText = 'Plaintext'

print('Encrypting...\n------------------')

print('Key is: ', key, '\n')

cipherText = RC4.encrypt(key, plainText)

print('Decrypting...\n------------------')

print('Key is: ', key, '\n')

print('Ciphertext is: ', ([hex(c) for c in cipherText]), '\n')

RC4.decrypt(key, cipherText)