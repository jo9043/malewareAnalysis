rule adware : ads android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection adware"

	strings:
	$a0 = "banner_layout"
	$a1 = "activity_adpath_sms"
	$a2 = "adpath_title_one"
	$a3 = "7291-2ec9362bd699d0cd6f53a5ca6cd"

	condition:
	all of them

}