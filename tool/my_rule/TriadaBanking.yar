rule Triada : android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection Android.Triada.Malware"
	ref = "https://securelist.com/analysis/publications/74032/attack-on-zygote-a-new-twist-in-the-evolution-of-mobile-threats/"

	strings:
	$a0 = "android/system/PopReceiver"
	$perm0 = "android.permission.KILL-BACKGROUND_PROCESSES"
	$perm1 = "android.permission.SYSTEM_ALERT_WINDOW"
	$perm2 = "android.permission.GET_TASKS"

	condition:
	$a0 and $perm0 and $perm1 and $perm2

}