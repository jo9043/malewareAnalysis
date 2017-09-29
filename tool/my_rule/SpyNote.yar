import "hash"

rule SpyNote
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection adware"
	ref = "http://researchcenter.paloaltonetworks.com/2016/07/unit42-spynote-android-trojan-builder-leaked/"

	strings:
	$a0 = "SERVER_IP" nocase
	$a1 = "SERVER_NAME" nocase
	$a2 = "content://sms/inbox"
	$a3 = "screamHacker"
	$a4 = "screamon"
	$pkg = "dell.scream.application"

	condition:
	hash.md5(0, filesize) == "219D542F901D8DB85C729B0F7AE32410096077CB" or
	$pkg or all of ($a*)
}