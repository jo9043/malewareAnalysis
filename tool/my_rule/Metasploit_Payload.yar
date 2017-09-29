rule Metasploit_Payload
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Metasploit_Payload"

	strings:
	$a0 = "com.metasploit.meterpreter.AndroidMeterpreter"
	$a1 = "com/metasploit/stage/MainBroadcastReceiver;"
	$a2 = "com/metasploit/stage/MainActivity;"
	$a3 = "com/metasploit/stage/Payload;"
	$a4 = "com/metasploit/stage/a;"
	$a5 = "com/metasploit/stage/c;"
	$a6 = "com/metasploit/stage/b;"

	condition:
	any of them
}