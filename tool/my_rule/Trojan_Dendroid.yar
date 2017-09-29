rule Trojan_Dendroid
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of dendroid trojan"

	strings:
	$a0 = "/upload-pictures.php?"
	$a1 = "/get-functions.php?"
	$a2 = "/new-upload.php?"
	$a3 = "/message.php?"
	$a4 = "/get.php?"

	condition:
	3 of them
}

rule Dendroid : android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of dendroid RAT"
	ref = "https://koodous.com/"

	strings:
    $s1 = "/upload-pictures.php?"
    $s2 = "Opened Dialog:"
    $s3 = "com/connect/MyService"
    $s4 = "android/os/Binder"
    $s5 = "android/app/Service"

   	condition:
    all of them
}

rule Dendroid_2 : android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of dendroid service"
	ref = "https://koodous.com/"

	strings:
   	$a = "Droidian"
   	$b = "DroidianService"

   	condition:
   	all of them

}

rule Dendroid_3 : android
{
	meta:
	author ="https://www.github.com/jo9043"
	ref = "https://koodous.com/"
	description = "Dendroid evidences via ServiceReceiver"

	strings:
   	$1 = "ServiceReceiver"
   	$2 = "Dendroid"

   	condition:
   	all of them
}

rule Android_Dendroid
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Dendroid evidences via ServiceReceiver"
	ref = "https://blog.lookout.com/blog/2014/03/06/dendroid/"

	strings:
	$ser = "com.connect"
    $perm = "android.permission.RECEIVE_BOOT_COMPLETED"

    condition:
    all of them
}













