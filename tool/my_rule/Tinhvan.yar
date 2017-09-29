import "hash"

rule Tinhvan : android
{
	meta:
	author ="https://www.github.com/jo9043"
	reference = "https://koodous.com/"

	condition:
	hash.md5(0, filesize) == "0DFBBDB7735517748C3DEF3B6DEC2A800182D1D5"
}
