def expand(x):
    """
    Implements the expander operation from the algorithm. 

        Parameter:
            x (int): 6-bits number 

    Returns:
            Expanded version of x
    """
    expanded = 0
    bits = []
    
    for i in range(0, 6):
        bit = x & 0b1
        x = x >> 1
        bits.append(bit)
        
    # [6, 5, 4, 3, 2, 1] -- View of where bits end up in list

    expanded = (expanded) | bits[5]
    expanded = (expanded << 1) | bits[4]
    expanded = (expanded << 1) | bits[2]
    expanded = (expanded << 1) | bits[3]
    expanded = (expanded << 1) | bits[2]
    expanded = (expanded << 1) | bits[3]
    expanded = (expanded << 1) | bits[1]
    expanded = (expanded << 1) | bits[0]
    
    # Input is: 011001
    # Output should be: 01010101
    
    return expanded
    
        
    

def s1(x):
    """
    S-box one for the DES-like algorithm
    
    Parameter:
        x (int): 4-bit input
        
    Returns:
        3-bit substitution value for the given x
    """
    
    assert x >= 0 and x <= 0b1111, "Invalid input to sbox 1"
    sbox1 = (
		(0b101, 0b010, 0b001, 0b110, 0b011, 0b100, 0b111, 0b000), 
		(0b001, 0b100, 0b110, 0b010, 0b000, 0b111, 0b101, 0b011)
	) 
    
    x1 = x >> 3
    x2 = x & 0b111
    
    return sbox1[x1][x2]
	

def s2(x):
    """
    S-box two for the DES-like algorithm

    Parameter:
        x (int): 4-bit input
 
    Returns:
        3-bit substitution value for the given x
    """
    
    assert x >= 0 and x <= 0b1111, "Invalid input to sbox2"
    sbox2 = (
        (0b100, 0b000, 0b110, 0b101, 0b111, 0b001, 0b011, 0b010),
        (0b101, 0b011, 0b000, 0b111, 0b110, 0b010, 0b001, 0b100)
    )
    
    x1 = x >> 3
    x2 = x & 0b111
    
    return sbox2[x1][x2]

def f(x, key):
    """
    f-function for the DES-like algorithm

    Parameters:
        x (int): plaintext to be encrypted   
        key (int): key to use for encryption

    Returns:
        f-value replacement for given input
    """
    
    expandedInput = expand(x)
    
    combined = expandedInput ^ key
    
    left = combined >> 4
    right = combined & 0b1111
    
    leftS = s1(left)
    rightS = s2(right)
    
    finalNum = (leftS << 3) | rightS
    
    return finalNum

def subkey(key, rnd):
    """
    Subkey derives 8 bits from the 9 bits input by
          counting 8 bits starting at position rnd 

	For example:
        master key = 110011010
	k1 = 11001101
	k2 = 10011010
	k3 = 00110101 # 7 bits + 1 bit from front
	k4 = 01101011 # 6 bits + 2 bits from front
	k5 = 11010110 # 5 bits + 3 bits from front

        Parameters:
            key (int): 9-bit master key to derive from
            rnd (int): index of subkey

        Returns:
            8-bit subkey derived from master key (key)
    """
    
    # k=key<<9 | key

    # k&=(2**(k.bit_length()-rnd+1) - 1)

    # k>>=(k.bit_length()-8)
    k = ((key << 9 | key) >> (11 - rnd)) & 0b11111111

    return k
    
def round(x, key, rnd):
    """
    Performs one round of encryption
    
    Parameters:
        x (int): 12-bit plaintext
        key (int): 9-bit key
        rnd (int): round to perform
        
    Returns:
        12-bit ciphertext for given round
    """
    
    l0 = x >> 6
    r0 = x & 0b111111
    
    r1 = f(r0, subkey(key, rnd)) ^ l0
    l1 = r0
    return l1 << 6 | r1

def encrypt(x, key):
	""" 
        DES-like encryption cipher for homework

        Parameters:
            x (int): 12-bit plaintext
            key (int): 9-bit key

        Returns:
            12-bit ciphertext
        """

	assert x >= 0 and x<=0b111111111111, "Invalid plaintext"
	assert key >= 0 and key<=0b111111111, "Invalid key"
	y=x
	for r in range(5):
		y=round(y, key, r+1)
	return y

# driver function with test cases
if __name__=="__main__":
	# assert expand(0b110011) == 0b11000011, "Expander failed" # Works
	# assert subkey(0b101100101, 4) == 0b10010110, "Subkey function failed" #Works
	# assert s1(0b1001) == 0b100, "S1 failed" # Works
	# assert s2(0b1001) == 0b011, "S2 failed" # Works
	# assert encrypt(0x726, 0x99) == 0x4d, "Encryption failed"
	# print("Ok")if __name__ == "__main__":

    assert f(0b100110, 0b01100101) == 0b000100, "f failed"

    assert subkey(0b101100101, 4) == 0b10010110, "subkey generator failed"

    assert expand(0b110011) == 0b11000011, "expander failed"

    assert s1(0b0011) == 0b110, "s1 failed"

    assert s2(0b0011) == 0b101, "s2 failed"

 

    plaintext=0x726

    key=0x99

    ciphertext=encrypt(plaintext, key)

 

    assert ciphertext == 0x3f8, "Encryption failed"

 

    print("Ok")