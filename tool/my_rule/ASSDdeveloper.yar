import "hash"

rule ASSD_developer : official android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of apks fom ASSD developer"
	ref = "https://koodous.com"

	condition:
	hash.md5(0, filesize) == "ED9A1CE1F18A1097DCCC5C0CB005E3861DA9C34A"
}