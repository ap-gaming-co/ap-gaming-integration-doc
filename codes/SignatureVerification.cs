using System;
using System.IO;
using System.Text;
using System.Security.Cryptography;

public class Signature {

    private static String initVector = "RandomInitVector";

    private static String agentCode = "SU107";              // Agent Code was provided
    private static	String aesKey = "rlpc3VsNcxXmrBXZ";     // AES key was provided
    private static	String agentKey = "b4dc8714-5d67-4798-a4eb-9478227c72ad";     // Agent key was provided 
    private static	String timestamp = DateTimeOffset.Now.ToUnixTimeMilliseconds().ToString();

    // Signature that you need generated. 
    // [We created it from our system. You need to create the same signature for comparison.]
    private static String signatureVerify = "B9Bp7loOzhvgHLLYg71A0v5yXKXTik87AjKCD8ZQSSVobuVHBkAVk8gxfwmWRglLCHm+CNaxnCa1neINbhRYMQ==";
    
    public static void Main(string[] args) {
        
        Signature signature = new Signature();
        String token = signature.encode();
        if(signatureVerify == token) {
            Console.WriteLine("Your signature was verified.");
            String tokenDecode = signature.decode(token);
            Console.WriteLine(tokenDecode);
            String[] tmp = tokenDecode.Split('|');
            Console.WriteLine("UserCode:" + tmp[0]);
            Console.WriteLine("Timestamp:" + tmp[1]);
        } else {
            Console.WriteLine("This is not your signature.");
        }
    }

    public String encode() {
        String hashToken = hash(agentCode + timestamp + agentKey);
        return encryptAES(agentCode + "|" + timestamp + "|" + hashToken);
    }

    public String decode(String token) {
        return 	decryptAES(token);
    }
    

    private static AesManaged CreateAes() {
        var aes = new AesManaged();
        aes.Key = System.Text.Encoding.UTF8.GetBytes(aesKey); //UTF8-Encoding
        aes.IV = System.Text.Encoding.UTF8.GetBytes(initVector);//UT8-Encoding
        return aes;
    }
    
    private string encryptAES(string text) {
        using (AesManaged aes = CreateAes())
        {
            ICryptoTransform encryptor = aes.CreateEncryptor();
            using (MemoryStream ms = new MemoryStream())
            {
                using (CryptoStream cs = new CryptoStream(ms, encryptor, CryptoStreamMode.Write))
                {
                    using (StreamWriter sw = new StreamWriter(cs))
                        sw.Write(text);
                    return Convert.ToBase64String(ms.ToArray());
                }
            }
        }
    }
    
    private string decryptAES(string text) {
        using (var aes = CreateAes()) {
            ICryptoTransform decryptor = aes.CreateDecryptor();
            using (MemoryStream ms = new MemoryStream(Convert.FromBase64String(text)))
            {
                using (CryptoStream cs = new CryptoStream(ms, decryptor, CryptoStreamMode.Read))
                {
                    using (StreamReader reader = new StreamReader(cs))
                    {
                        return reader.ReadToEnd();
                    }
                }
            }

        }
    }
	
	private String hash(String input) {
		MD5 md5 = System.Security.Cryptography.MD5.Create();
		byte[] inputBytes = Encoding.UTF8.GetBytes(input);
		byte[] hashBytes = md5.ComputeHash(inputBytes);

		// Step 2, convert byte array to hex string
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hashBytes.Length; i++)
		{
			sb.Append(hashBytes[i].ToString("x2"));
		}
		return sb.ToString();
	}
        
}
