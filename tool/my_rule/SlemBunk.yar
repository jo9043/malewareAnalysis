rule SlemBunk : android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection trojans imitating banks of North America, Europe and Asia"

	strings:
	$a0 = "#intercept_sms_start"
	$a1 = "#intercept_sms_stop"
	$a2 = "#block_numbers"
	$a3 = "wipe_data"
	$a4 = "Visa Electron"

	condition:
	all of them
}