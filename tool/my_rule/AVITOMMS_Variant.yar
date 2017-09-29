rule AVITOMMS_Variant
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Spy.Banker AVITO-MMS"
	ref = "https://blog.avast.com/android-banker-trojan-preys-on-credit-card-information"

	strings:
	$rec0 = "AlarmReceiverKnock"
	$rec1 = "BootReciv"
	$rec2 = "AlarmReceiverAdm"

	condition:
	all of them
}

rule AVITOMMS_Rule2
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Spy.Banker AVITO-MMS"

	strings:
	$ser = "IMService"
	$rec = "BootReciv"
	$perm0 = "android.permission.RECEIVE_BOOT_COMPLETED"
	$perm1 = "android.permission.KILL_BACKGROUND_PROCESSES"
	$perm2 = "android.permission.SEND_SMS"
	$perm3 = "android.permission.INTERNET"

	condition:
	all of them

}









