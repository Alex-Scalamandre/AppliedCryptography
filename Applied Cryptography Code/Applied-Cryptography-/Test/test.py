hex_input  = '5343530308005344564b485f427f5256454341444d'
dec_output = [
    int(hex_input[0:2], 16), int(hex_input[2:4], 16),
    int(hex_input[4:6], 16), int(hex_input[6:8], 16),
    int(hex_input[8:10], 16), int(hex_input[10:12], 16),
    int(hex_input[12:14], 16), int(hex_input[14:16], 16),
    int(hex_input[16:18], 16), int(hex_input[18:20], 16),
]
Dec_out =[dec_output[c] + 16 for c in range(0,9)]
    
print(Dec_out) # [192, 168, 0, 38]

