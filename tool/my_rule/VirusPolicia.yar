rule BaDoink : official android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Mobile_Malware Yara Rule index"
	ref = "https://koodous.com/"

	strings:
	$app_name = "BaDoink"
	$url0 = "http://police-mobile-stop.com"
	$url1 = "http://mobile-policeblock.com"
	$a ="6589y459gj4058rt"
	$b0 = "Q,hu4P#hT;U!XO7T,uD"
	$b1 = "+Gkwg#M!lf>Laq&+J{lg"
	$c0 = "ANIM_STYLE_CLOSE_ENTER"
	$c1 = "TYPE_VIEW_ACCESSIBILITY_FOCUSED"
	$c2 = "TYPE_VIEW_TEXT_SELECTION_CHANGED"
	$c3 = "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY"

	condition:
	$app_name or all of ($url*) or $a or all of ($b*) or all of ($c*)
}