rule Meterpreter
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Meterpreter"

	strings:
	$a0 = "META_INF/PK"
	$a1 = "[Hp^"
	$a2 = /;.Sk/
	$b0 = "eval"
	$b1 = "base64_decode"

	condition:
	all of ($a*) or all of ($b*)
}


rule Metasploit
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Metasploit"

	strings:
	$a0 = "com/metasploit/stage/PayloadTrustManager;"
	$a1 = "com.metasploit.stage.PayloadTrustManager"
	$a2 = "com/metasploit/stage/Payload$1;"
	$a3 = "com/metasploit/stage/Payload;"

	condition:
	all of them
}