rule SMSFraud : android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection SMSFraud trojan"

	strings:
	$a0 = "E!QQAZXS"
	$a1 = "res/layout/notify_apkinstall.xmlPK"

	condition:
	all of them
}

rule SMSFraud2 : android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection SMSFraud trojan"

	strings:
	$b0 = "pluginSMS_decrypt"
	$b1 = "pluginSMS_encrypt"
	$b2 = "__dso_handle"
	$b3 = "lib/armeabi/libmylib.soUT"
	$b4 = "|Diok3|"

	condition:
	all of them

}