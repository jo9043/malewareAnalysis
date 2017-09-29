import "hash"

rule SkBank
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection trojan targeting South Korean banks"
	ref = "https://www.zscaler.com/blogs/research/android-malware-targeting-south-korean-mobile-users"

	strings:
	$a0 = "NPKI"
	$a1 = "portraitCallBack("
	$a2 = "android.app.extra.DEVICE_ADMIN"
	$a3 = "SMSReceiver&imsi="
	$a4 = "com.ahnlab.v3mobileplus"
	$pkg = "com.qbjkyd.rhsxa"
	$perm0 = "android.permission.RECEIVE_SMS"
	$perm1 = "android.permission.INTERNET"
	$perm2 = "android.permission.RECEIVE_BOOT_COMPLETED"

	condition:
	hash.md5(0, filesize) == "543382EDDAFC05B435F13BBE97037BB335C2948B" or
	$pkg or $perm0 and $perm1 and $perm2 and all of ($a*)

}