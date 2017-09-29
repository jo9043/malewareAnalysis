rule Android_RuMMS
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection Android.Banking.RuMMS"
	ref = "https://www.fireeye.com/blog/threat-research/2016/04/rumms-android-malware.html"

	strings:
	$pkg0 = "org.starsizew"
	$pkg1 = "com.tvone.untoenynh"
	$pkg2 = "org.zxformat"
	$perm0 = "android.permission.RECEIVE_SMS"
	$perm1 = "android.permission.RECEIVE_BOOT_COMPLETED"

	condition:
	$pkg0 or $pkg1 or $pkg2 and $perm0 and $perm1
}

rule Android_RuMMS_0
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection Android.Banking.RuMMS"
	ref = "https://www.fireeye.com/blog/threat-research/2016/04/rumms-android-malware.html"

	strings:
	$ser0 = ".Tb/"
	$ser1 = ".Ad"
	$rec0 = ".Ac"
	$rec1 = ".Ma"
	$url0 = "http://37.1.207/"
	$url1 = "/api/?id=7"

	condition:
	($ser0 and $ser1 and $rec0 and $rec1) or ($url0 and $url1)
}