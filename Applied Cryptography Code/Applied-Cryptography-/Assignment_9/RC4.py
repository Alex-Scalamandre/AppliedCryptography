from pydoc import plain

def KSA(key):
    ''' Key Scheduling Algorithm (from wikipedia):
        for i from 0 to 255
            S[i] := i
        endfor
        j := 0
        for i from 0 to 255
            j := (j + S[i] + key[i mod keylength]) mod 256
            swap values of S[i] and S[j]
        endfor
    '''
    
    keyLength = len(key)
    
    S = list(range(256))
    
    j = 0
    for i in range(256):
        j = (j + S[i] + key[i % keyLength]) % 256
        S[i], S[j] = S[j], S[i]
        
    return S

def PRGA(S, n):
    ''' Psudo Random Generation Algorithm (from wikipedia):
        i := 0
        j := 0
        while GeneratingOutput:
            i := (i + 1) mod 256
            j := (j + S[i]) mod 256
            swap values of S[i] and S[j]
            K := S[(S[i] + S[j]) mod 256]
            output K
        endwhile
    '''
    i = 0
    j = 0
    key = []
    
    while n > 0:
        n = n - 1
        i = (i + 1) % 256
        j = (j + S[i]) % 256

        S[i], S[j] = S[j], S[i]  # swap values
        K = S[(S[i] + S[j]) % 256]
        key.append(K)
    
    return key

def prepareKey(s):
    return [ord(c) for c in s]
        
def encrypt(key, plainText):

    key = prepareKey(key)

    # Create keystream
    S = KSA(key)
    keyStream = PRGA(S, len(plainText))
    
    # Convert to print as hex
    print('Key Stream is: ', [hex(c) for c in keyStream], '\n')
    
    print('Plaintext is: ', str(plainText), '\n')
    
    # Encrypt
    plainText = [ord(c) for c in plainText]    

    cipherT = []
    # Loop to XOR plainText and keyStream for encryption
    for c in range(0, len(plainText)):
        value = (plainText[c] ^ keyStream[c])
        cipherT.append(value)
        
    print('Ciphertext is: ', [hex(c) for c in cipherT], '\n')
    return cipherT
    
def decrypt(key, cipherText):
    
    key = prepareKey(key)
    
    S = KSA(key)
    keyStream = PRGA(S, len(cipherText))
    
    print('Key Stream is: ', [hex(c) for c in keyStream], '\n')
    
    plainT = []
    # Loop to XOR cipherText and keyStream for decryption
    for c in range(0, len(cipherText)):
        value = (cipherText[c] ^ keyStream[c]) 
        plainT.append(value)
    
    print('Plaintext is: ', ''.join([chr(c) for c in plainT]))