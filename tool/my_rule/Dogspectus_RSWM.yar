import "hash"

rule Android_Dogspectus_rswm
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Dogspectus intial ransomware apk"
	ref = "https://www.bluecoat.com/security-blog/2016-04-25/android-exploit-delivers-dogspectus-ransomware"

	strings:
	$str_1 = "android.app.action.ADD_DEVICE_ADMIN"
	$str_2 = "Tap ACTIVATE to continue with software update"
	$pkg = "net.prospectus"
	$name = "System update"
	$act0 = "Loganberry/i"
	$act1 = "net.prospectus.pu"
	$act2 = "PanickedActivity"
	$perm0 = "android.permission.INTERNET"
	$perm1 = "android.permission.WAKE_LOCK"
	$perm2 = "android.permission.RECEIVE_BOOT_COMPLETED"

	condition:
	hash.md5(0, filesize) == "180ADFC5DE49C0D7F643BD896E9AAC4B8941E44E" or
	($pkg and $name) or ($act0 or $act1 or $act2) or
	(all of ($perm*) and all of ($str_*))
}

rule Dogspectus
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Dogspectus"
	ref = "https://www.bluecoat.com/security-blog/2016-04-25/android-exploit-delivers-dogspectus-ransomware"

	strings:
	$act = "PanickedActivity"
	$perm0 = "android.permission.RECEIVE_BOOT_COMPLETED"
	$perm1 = "android.permission.INTERNET"
	$perm2 = "android.permission.WAKE_LOCK"

	condition:
	all of them
}















