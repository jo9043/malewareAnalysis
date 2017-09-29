1. Requirements
I-AV optimized for windows 64-bit.

I-AV needs python open source androguard
https://github.com/vivainio/androguard

I-AV needs python modules
1)Windows
	________________________________________________________________
	pip install python python-pyperclip ipython python-pydot pyfuzzy
	----------------------------------------------------------------

2)Linux
	____________________________________________________________________
	apt-get install python python-pyperclip ipython python-pydot pyfuzzy	
	--------------------------------------------------------------------

2. Using

1) Simple Analysis
File -> Select File, Run -> Simple Analysis -> Run

<File Information>
Shows File Path & File Information of target application from Google App Store

<Log>
Shows logs

<Total Permission>
Shows all permissions in AndroidManifest.xml of the target application

<Danger Permission>
Shows permissions that do not match the category of the target application

<Score>
Shows calcuated risk



2) Close Analysis
(File -> Select File), Run -> Close Analysis -> Run

<File Information>
Shows File Path

<Detecting Result>
Shows the type of malware detected by Yara

3. demonstration
1) Simple Anlaysis
https://youtu.be/KtLROiqwhxc

2) Close Anlaysis
https://youtu.be/QDZ-7RzHKqk

