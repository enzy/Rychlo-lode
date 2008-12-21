VERSION 5.00
Begin VB.Form Form5 
   BorderStyle     =   4  'Fixed ToolWindow
   Caption         =   " Kdo vyhrál"
   ClientHeight    =   1215
   ClientLeft      =   45
   ClientTop       =   315
   ClientWidth     =   4680
   Icon            =   "Form5.frx":0000
   LinkTopic       =   "Form5"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   81
   ScaleMode       =   3  'Pixel
   ScaleWidth      =   312
   ShowInTaskbar   =   0   'False
   StartUpPosition =   1  'CenterOwner
   Begin VB.PictureBox Hum 
      Height          =   825
      Left            =   2430
      Picture         =   "Form5.frx":000C
      ScaleHeight     =   765
      ScaleWidth      =   1995
      TabIndex        =   2
      Top             =   1470
      Width           =   2055
   End
   Begin VB.PictureBox PC 
      Height          =   825
      Left            =   90
      Picture         =   "Form5.frx":1670
      ScaleHeight     =   765
      ScaleWidth      =   2145
      TabIndex        =   1
      Top             =   1470
      Width           =   2205
   End
   Begin VB.CommandButton cmd1 
      BackColor       =   &H00000000&
      Default         =   -1  'True
      Height          =   1155
      Left            =   30
      Picture         =   "Form5.frx":2B31
      Style           =   1  'Graphical
      TabIndex        =   0
      Top             =   30
      Width           =   4605
   End
End
Attribute VB_Name = "Form5"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub cmd1_Click()
Unload Me
End Sub
