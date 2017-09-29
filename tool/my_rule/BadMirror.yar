rule BadMirror
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of BadMirror"

	strings:
	$ser = "SimInsService"
	$perm = "android.permission.READ_PHONE_STATE"

	condition:
	all of them
}