import "hash"

rule pinkLocker :android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection Android Locker app named Pink Club"
	ref1 = "https://www.virustotal.com/es/file/388799cbbe2c8ddc0768c4b994379508e602f68503888a001635c3be2c8c350d/analysis/"
	ref2 = "https://analyst.koodous.com/rulesets/1186"

	strings:
	$a0 = "arnrsiec sisani"
	$a1 = "rhguecisoijng ts"
	$a2 = "assets/data.db"
	$a3 = "res/xml/device_admin_sample.xmlPK"
	$url = "lineout.pw/"
	$perm0 = "android.permission.Internet"
	$perm1 = "android.permission.DISABLE_KEYGUARD"

	condition:
	hash.md5(0, filesize) == "D88B53449F6CAC93E65CA5E224A5EAD3E990921E" or
	$url or $perm0 and $perm1 and all of ($a*)
}