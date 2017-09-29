import "hash"

rule AliPay_SmsStealer : android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection Fake AliPay SMS Stealer"
	ref = "https://analyst.koodous.com/rulesets/1192"

	strings:
	$a0 = "START_SERVICE"
	$a1 = "extra_key_sms"
	$a2 = "android.provider.Telephony.SMS_RECEIVED"
	$a3 = "mPhoneNumber"
	$perm0 = "android.permission.RECEIVE_SMS"
	$perm1 = "android.permission.INTERNET"
	$perm2 = "android.permission.RECEIVE_BOOT_COMPLETED"

	condition:
	hash.md5(0, filesize) == "0CDFC700D0BDDC3EA50D71B54594BF3711D0F5B2" or
	$perm0 and $perm1 and $perm2 and all of ($a*)


}