import "hash"

rule Hacking_team : stcert android
{
	meta:
	author ="https://www.github.com/jo9043"
	reference = "https://koodous.com/"
	description = "Detection of hacking_team"

	strings:
	$a0 = "280128120000Z0W1"
	$a1 = "E6FFF4C5062FBDC9"
	$a2 = "886FEC93A75D2AC1"
	$a3 = "121120104150Z"
	$b0 = "&inbox_timestamp > 0 and is_permanent=1"
	$b1 = "contact_id = ? AND mimetype = ?"
	$c = "863d9effe70187254d3c5e9c76613a99"
	$d = "nv-sa1"

	condition:
	hash.md5(0, filesize) == "B1BC968BD4F49D622AA89A81F2150152A41D829C" or
	hash.md5(0, filesize) == "3FEC88BA49773680E2A3040483806F56E6E8502E" or
	hash.md5(0, filesize) == "B0A4A4880FA5345D6B3B00C0C588A39815D3872E" or
	hash.md5(0, filesize) == "EC2184676D4AE153E63987326666BA0C554A4A60" or
	hash.md5(0, filesize) == "A7394CBAB09D35C69DA7FABB1A7870BE987A5F77" or
	hash.md5(0, filesize) == "A1131C7F816D65670567D6C7041F30E380754022" or
	hash.md5(0, filesize) == "4E40663CC29C1FE7A436810C79CAB8F52474133B" or
	hash.md5(0, filesize) == "159B4F6C03D43F27339E06ABFD2DE8D8D65516BC" or
	hash.md5(0, filesize) == "3EEE4E45B174405D64F877EFC7E5905DCCD73816" or
	hash.md5(0, filesize) == "9CE815802A672B75C078D920A5D506BBBAC0D5C9" or
	hash.md5(0, filesize) == "C4CF31DBEF79393FD2AD617E79C27BFCF19EFBB3" or
	hash.md5(0, filesize) == "2125821BC97CF4B7591E5C771C06C9C96D24DF8F" or
	(any of ($a*) and any of ($b*) and $c and $d)


}
