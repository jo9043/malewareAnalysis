rule SMSpay_chinnese : hejupay android
{
    meta:
	author ="https://www.github.com/jo9043"
	reference = "https://koodous.com/"

	strings:
  	$a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/Jvgb0/jSRWi7i4J9IwO72KZw404kj02A97ExbUefVeE7yyWSTbKw5sYlKXCtaoQwWr19j0Y+xb6+h2BRuNx307BV/QpG6DnPg+Lx8fPPvhbhOudgKb/XuZPaz/GJbTpwzTbBmT+mI1QTRLyAKDxSjGWYvoPFVz82RxcAblV/twIDAQAB"

	$b = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAL8m+BvT+NJFaLuLgn0jA7vYpnDjTiSPTYD3sTFtR59V4TvLJZJNsrDmxiUpcK1qhDBavX2PRj7Fvr6HYFG43HfTsFX9CkboOc+D4vHx88++FuE652Apv9e5k9rP8YltOnDNNsGZP6YjVBNEvIAoPFKMZZi+g8VXPzZHFwBuVX+3AgMBAAECgYBLYR6uOqUApoZqjtVia5BpX0Ijej+ygyBZH1Qs3Z9E4iTz42RpkWJKCHdS6Eia2kpOlznqbbmRv4E8uT3ufCvUFexjR5ClGVKJ+XHXxqS75+KT38wGZZ1bW0pK4sT1/aGLrt5/netwuzMi/YFNfAKRPqvRXuNcxNLhMhs2efLKIQJBAPGea2UXVWd0Ti8ClA8hiWPSNCPtcp41Dh2H0YczrFmO2zafPPJih2GQY5txszwBLbjxFCY8/WhrYAqx0itMrgsCQQDKh5U1NfpRvk0Hu8iBRB/LPyGimz+WM/chFSC65SlS/cml3U7hUOj2lRGPz+bm68624H0KLviqpBJpmayvbbyFAkEA1NNFJ9uAx8rDn1b3EcjpmvqqIMdjwYVcNJjQ7/WNJ6nU3+0toxc0xrSHeIGTbhRfsNrxc6kfUV3bUDBHvwog9wJBAI+fRH1ekOwlAqVIUnDw6YcNdwHEDHysz0TDodlHp112Ieign06DPSGYJsMQURNTB92CJsnw82C3R2Nhmicxr60CQQCN466JF9GJRZipO64OYw/ElMac7vXgTeGMvYZ2/yfX5CRCLua4DygD1Ju0eMXpea9og/EtwCTV0RVpFc9SSN8V"

	condition:
	$a or $b
}


rule SMSfraud : ganga android
{
	meta:
	author ="https://www.github.com/jo9043"
	reference = "https://koodous.com/"
	description = "smsfraud chinese"


	strings:
	$str1 = "HHHEEEEEEBBBBBB??????;;;;;;888888444444000000,,,,,,''''''''''''######OOO###"
	$str2 = "2e6081a2-a063-45c7-ab90-5db596e42c7c"
	$pkg = "com.yr.sx"
	$act = "com.snowfish.cn.ganga.offline.helper.SFGameSplashActivity"

	condition:
	$pkg or	all of ($str*) or $act
}

rule SMS_fraud : MSACM32 android
{
	meta:
	author ="https://www.github.com/jo9043"
	reference = "https://koodous.com/"
	description = "sms-fraud examples"


	strings:
	$str0 = "MSACM32.dll"
	$str1 = "android.provider.Telephony.SMS_RECEIVED"
	$str2 = "MAIN_TEXT_TAG"
	$perm = "android.permission.SEND_SMS"

	condition:
	all of ($str*) and $perm
}

rule SMS_fraud_gen : generic android
{
	meta:
	author ="https://www.github.com/jo9043"
	reference = "https://koodous.com/"
	description = "This is just an example"

	strings:
	$a0 = "080229013346Z"
	$a1 = "350717013346Z0"
	$a2 = "NUMBER_CHAR_EXP_SIGN"
	$perm = "android.permission.SEND_SMS"

	condition:
	all of them
}

import "hash"

rule SMSfraud_apk : android
{
	meta:
	author ="https://www.github.com/jo9043"
	reference = "https://koodous.com/"
	description = "This rule detects apks related with sms fraud"

	condition:
	hash.md5(0, filesize) == "9E1B8719D80656E9EADAAB4251B2CFB4C8188835"

}
