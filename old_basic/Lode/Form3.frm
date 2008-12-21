VERSION 5.00
Begin VB.Form Form3 
   BackColor       =   &H00000000&
   BorderStyle     =   1  'Fixed Single
   Caption         =   " Høáè 2"
   ClientHeight    =   6630
   ClientLeft      =   45
   ClientTop       =   435
   ClientWidth     =   4605
   ForeColor       =   &H00FFFFFF&
   Icon            =   "Form3.frx":0000
   LinkTopic       =   "Form3"
   MaxButton       =   0   'False
   ScaleHeight     =   442
   ScaleMode       =   3  'Pixel
   ScaleWidth      =   307
   StartUpPosition =   1  'CenterOwner
   Begin VB.PictureBox vzorLod 
      Height          =   615
      Left            =   4500
      ScaleHeight     =   555
      ScaleWidth      =   615
      TabIndex        =   1
      Top             =   4650
      Visible         =   0   'False
      Width           =   675
   End
   Begin VB.CommandButton cmdNovaHrasKamosem 
      BackColor       =   &H00000000&
      Height          =   900
      Left            =   60
      Picture         =   "Form3.frx":058A
      Style           =   1  'Graphical
      TabIndex        =   0
      Top             =   5700
      Width           =   4515
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   48
      Left            =   3840
      Top             =   4500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   47
      Left            =   3240
      Top             =   4500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   46
      Left            =   2640
      Top             =   4500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   45
      Left            =   2040
      Top             =   4500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   44
      Left            =   1440
      Top             =   4500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   43
      Left            =   840
      Top             =   4500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   42
      Left            =   240
      Top             =   4500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   41
      Left            =   3840
      Top             =   3900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   40
      Left            =   3240
      Top             =   3900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   39
      Left            =   2640
      Top             =   3900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   38
      Left            =   2040
      Top             =   3900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   37
      Left            =   1440
      Top             =   3900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   36
      Left            =   840
      Top             =   3900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   35
      Left            =   240
      Top             =   3900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   34
      Left            =   3840
      Top             =   3300
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   33
      Left            =   3240
      Top             =   3300
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   32
      Left            =   2640
      Top             =   3300
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   31
      Left            =   2040
      Top             =   3300
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   30
      Left            =   1440
      Top             =   3300
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   29
      Left            =   840
      Top             =   3300
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   28
      Left            =   240
      Top             =   3300
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   27
      Left            =   3840
      Top             =   2700
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   26
      Left            =   3240
      Top             =   2700
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   25
      Left            =   2640
      Top             =   2700
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   24
      Left            =   2040
      Top             =   2700
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   23
      Left            =   1440
      Top             =   2700
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   22
      Left            =   840
      Top             =   2700
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   21
      Left            =   240
      Top             =   2700
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   20
      Left            =   3840
      Top             =   2100
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   19
      Left            =   3240
      Top             =   2100
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   18
      Left            =   2640
      Top             =   2100
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   17
      Left            =   2040
      Top             =   2100
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   16
      Left            =   1440
      Top             =   2100
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   15
      Left            =   840
      Top             =   2100
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   14
      Left            =   240
      Top             =   2100
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   13
      Left            =   3840
      Top             =   1500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   12
      Left            =   3240
      Top             =   1500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   11
      Left            =   2640
      Top             =   1500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   10
      Left            =   2040
      Top             =   1500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   9
      Left            =   1440
      Top             =   1500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   8
      Left            =   840
      Top             =   1500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   7
      Left            =   240
      Top             =   1500
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   6
      Left            =   3840
      Top             =   900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   5
      Left            =   3240
      Top             =   900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   4
      Left            =   2640
      Top             =   900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   3
      Left            =   2040
      Top             =   900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   2
      Left            =   1440
      Top             =   900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   1
      Left            =   840
      Top             =   900
      Width           =   480
   End
   Begin VB.Image pol 
      Appearance      =   0  'Flat
      Height          =   480
      Index           =   0
      Left            =   240
      Top             =   900
      Width           =   480
   End
   Begin VB.Label Label1 
      Alignment       =   2  'Center
      BackColor       =   &H00000000&
      BackStyle       =   0  'Transparent
      Caption         =   "Umístìte si vaše lodì"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   20.25
         Charset         =   238
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FFFFFF&
      Height          =   495
      Left            =   0
      TabIndex        =   3
      Top             =   120
      Width           =   4575
   End
   Begin VB.Line Line1 
      BorderColor     =   &H00FFFFFF&
      X1              =   0
      X2              =   308
      Y1              =   352
      Y2              =   352
   End
   Begin VB.Label lblVolnePozice 
      BackStyle       =   0  'Transparent
      Caption         =   "Zde umístìte vašich 6 lodí"
      ForeColor       =   &H00FFFFFF&
      Height          =   195
      Left            =   60
      TabIndex        =   2
      Top             =   5400
      Width           =   4380
   End
   Begin VB.Line Line2 
      BorderColor     =   &H00FFC0C0&
      Index           =   0
      X1              =   52
      X2              =   52
      Y1              =   60
      Y2              =   332
   End
   Begin VB.Line Line2 
      BorderColor     =   &H00FFC0C0&
      Index           =   1
      X1              =   92
      X2              =   92
      Y1              =   60
      Y2              =   332
   End
   Begin VB.Line Line2 
      BorderColor     =   &H00FFC0C0&
      Index           =   2
      X1              =   132
      X2              =   132
      Y1              =   60
      Y2              =   332
   End
   Begin VB.Line Line2 
      BorderColor     =   &H00FFC0C0&
      Index           =   3
      X1              =   172
      X2              =   172
      Y1              =   60
      Y2              =   332
   End
   Begin VB.Line Line2 
      BorderColor     =   &H00FFC0C0&
      Index           =   4
      X1              =   212
      X2              =   212
      Y1              =   60
      Y2              =   332
   End
   Begin VB.Line Line2 
      BorderColor     =   &H00FFC0C0&
      Index           =   5
      X1              =   252
      X2              =   252
      Y1              =   60
      Y2              =   332
   End
   Begin VB.Line Line3 
      BorderColor     =   &H00FFC0C0&
      Index           =   0
      X1              =   16
      X2              =   288
      Y1              =   96
      Y2              =   96
   End
   Begin VB.Line Line3 
      BorderColor     =   &H00FFC0C0&
      Index           =   1
      X1              =   16
      X2              =   288
      Y1              =   136
      Y2              =   136
   End
   Begin VB.Line Line3 
      BorderColor     =   &H00FFC0C0&
      Index           =   2
      X1              =   16
      X2              =   288
      Y1              =   176
      Y2              =   176
   End
   Begin VB.Line Line3 
      BorderColor     =   &H00FFC0C0&
      Index           =   3
      X1              =   16
      X2              =   288
      Y1              =   216
      Y2              =   216
   End
   Begin VB.Line Line3 
      BorderColor     =   &H00FFC0C0&
      Index           =   4
      X1              =   16
      X2              =   288
      Y1              =   256
      Y2              =   256
   End
   Begin VB.Line Line3 
      BorderColor     =   &H00FFC0C0&
      Index           =   5
      X1              =   16
      X2              =   288
      Y1              =   296
      Y2              =   296
   End
   Begin VB.Image imgPozadi1 
      Height          =   4500
      Left            =   60
      Picture         =   "Form3.frx":1602
      ToolTipText     =   "Zde si umístìte vaše lodì  |  Umístíte je kliknutím na levé tlaèítko myši."
      Top             =   720
      Width           =   4500
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Form_Load()
pocetLodi = 0
vzorLod.Picture = Form1.vzorLod.Picture

'For i = 0 To 6
    'Lod(i) = 0
'Next i
End Sub

Private Sub pol_Click(Index As Integer)
    If pol(Index).Picture = Me.Picture Then
        If pocetLodi <> 6 Then
            pol(Index).Picture = vzorLod.Picture
            pocetLodi = pocetLodi + 1
        End If
    ElseIf pol(Index).Picture = vzorLod.Picture Then
        pol(Index).Picture = Me.Picture
        pocetLodi = pocetLodi - 1
    End If
    
lblVolnePozice.Caption = "Zbývá vám volných lodí: " & 6 - pocetLodi
End Sub
