import "hash"

rule Spywaller : android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Android Spywaller"

	strings:
	$a0 = "droid.png"
	$a1 = "getSrvAddr"
	$a2 = "getSrvPort"
	$a3 = "android.intent.action.START_GOOGLE_SERVICE"
	$perm0 = "android.permission.INTERNET"
	$perm1 = "android.permission.READ_PHONE_STATE"

	condition:
	hash.md5(0, filesize) == "165F84B05BD33DA1BA0A8E027CEF6026B7005978" or
	$perm0 and $perm1 and all of ($a*)

}