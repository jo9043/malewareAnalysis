rule Tachi : android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection tachi apps (not all malware)"

	strings:
	$a = "svcdownload"
	$xml0 = "<config>"
	$xml1 = "<apptitle>"
	$xml2 = "<txinicio>"
	$xml3 = "<txiniciotitulo>"
	$xml4 = "<txnored>"
	$xml5 = "<txnoredtitulo>"
	$xml6 = "<txnoredretry>"
	$xml7 = "<txnoredsalir>"
	$xml8 = "<laurl>"
	$xml9 = "<txquieresalir>"
	$xml10 = "<txquieresalirtitulo>"
	$xml11 = "<txquieresalirsi>"
	$xml12 = "<txquieresalirno>"
	$xml13 = "<txfiltro>"
	$xml14 = "<txfiltrourl>"
	$xml15 = "<posicion>"

	condition:
	$a and 4 of ($xml*)
}