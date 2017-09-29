rule batterybotpro : ClickFraud AdFraud SMS Downloader_Trojan android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of fake-batterybotpro"
	ref = "https://twitter.com/fdrg21"

	strings:
	$act = "com.polaris.BatteryIndicatorPro.BatteryInfoActivity/i"
	$perm = "android.permission.SEND_SMS"

	condition:
	$act and $perm
}