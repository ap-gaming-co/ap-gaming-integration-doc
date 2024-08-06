<?php
// Agent Code was provided
define("AGENT_CODE", "SU107");
// Agent key was provided
define("AGENT_KEY", "b4dc8714-5d67-4798-a4eb-9478227c72ad");
// AES key was provided
define("AES_KEY", "rlpc3VsNcxXmrBXZ");

define("IV", "RandomInitVector");

class Signature {
    
    /**
     * encode to generate signature.
     */
    public function encode() {
		 $timestamp = time()*1000;
		 $hashToken = md5(AGENT_CODE. $timestamp . AGENT_KEY);
		 $tokenPayLoad = AGENT_CODE . '|' . $timestamp . '|' . $hashToken;
		 return $this->encryptAES(AES_KEY, $tokenPayLoad);
		 return $token;
    }

    /**
     * decode signature get from request body.
     */
    public function decode($encryptedText) {
        return $this->str_decryptaesgcm($encryptedText, AES_KEY);
    }
	

    /**
    * encrypt with AES algorithms.
    */
	private function encryptAES($secretKey, $tokenPayLoad){
		$encrypt = openssl_encrypt($tokenPayLoad, "AES-128-CBC", $secretKey, OPENSSL_RAW_DATA, IV);
		return base64_encode($encrypt);
	}


     /**
      * dencrypt with AES algorithms.
      *
      * @param $encryptedText signature from request body.
      * @param $secretKey secret key 
      * @return string after decryption.
      */
	function str_decryptaesgcm($encryptedText, $secretKey) {
		if ($encryptedText != null && $secretKey != null) {
			$encryptedText = base64_decode($encryptedText);
			return openssl_decrypt($encryptedText, "AES-128-CBC", $secretKey, OPENSSL_RAW_DATA, IV);
		}
	}
}
?>
