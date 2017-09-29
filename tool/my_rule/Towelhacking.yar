import "hash"

rule Towelhacking_behaviour
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Search apk relationships"

	strings:
	$act = "/net.prospectus.*/i"
	$perm0 = "android.permission.WRITE_CONTACT"
	$perm1 = "android.permission.ACCES_COARSE_UPDATES"

	condition:
	hash.md5(0, filesize) == "180ADFC5DE49C0D7F643BD896E9AAC4B8941E44E" or
	($act and $perm0 and $perm1)

}

rule Towelhacking_analysis
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "from static analysis"

	strings:
	$a0 = "LoganberryApplication"
	$a1 = "attachBaseContext"
	$a2 = "Obstetric"

	condition:
	all of them
}

rule Towelhacking_cromosome
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "From cromosome.py"

	strings:
	$cromosome_a = "res/xml/device_admin_data.xml]"
	$cromosome_b = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACABAMAAAAxEHz4AAAAGFBMVEVMaXGUwUWTwEaTwEaTwEaTwEaVwUWTwEalNfqIAAAAB3RSTlMALozOuetYmPN8xgAAAbFJREFUeF7t2E9L+zAcx/FP1i3n7PfHXauivW7K3HWAY1dFoNci2l61Lvs8fUOxZYW22RdBBub1AN4kX7KQDqcvCILgDC0aUlcGhzaQ+j/HAb2HlC5buTXEEoMGlgZikzkAledTAKM95HSJPxs6T9eYrSGHZMMvuyXkoLZs2AxyCQ98GEi9sqWEkGYb1/INMGUtFW9iRDLWdWGhtuQCEgW5a+ZIgwn5AQFVjQ0zViwQkYwFgYjVCorDFfBdtgMyU80MkFC2h5SOXfGLXbIqyg9B2xzHGrODZAgzdioFM+y0E5zjThbHurzthl9Bb24M8HLfzQCXT+cYsiX3QMJuBn9Jazz3CLOBwIrko+8IzvsDmk7pO4Lv/YExPT/rxBOI6NjTCIRACIRACITA2BeY0XnoD4x8D5WITtwfUKnnraVScof+AArfk/cfbTwU0CveYdDUYCgANYXPYKBx+oEQKL772I7YaS/+cG+zMY6m8vyFDnOnqpV5nkFkVI+tvmWAXxkIgRDQdGxzO7xBSqX1B9qEzhpiBcmHei3WQEyn9d9fr+QCcji7yFDB8zV+QhAEQfAJcs5K2TAQqxAAAAAASUVORK5CYII="

	$cromosome_c = "device_admin_desc"
	$cromosome_d = "PillagedActivity"
	$cromosome_e = "EpigraphyService"

	condition:
	($cromosome_a and $cromosome_b) or ($cromosome_c and $cromosome_d and $cromosome_e)

}






















