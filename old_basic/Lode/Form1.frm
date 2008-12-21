VERSION 5.00
Begin VB.Form Form1 
   BackColor       =   &H00000000&
   BorderStyle     =   1  'Fixed Single
   Caption         =   " Rychlo lodì"
   ClientHeight    =   8115
   ClientLeft      =   45
   ClientTop       =   435
   ClientWidth     =   4665
   FillColor       =   &H00FFC0C0&
   ForeColor       =   &H00FFFFFF&
   Icon            =   "Form1.frx":0000
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   ScaleHeight     =   541
   ScaleMode       =   3  'Pixel
   ScaleWidth      =   311
   StartUpPosition =   2  'CenterScreen
   Begin VB.Timer tmrAnimaceVln 
      Interval        =   100
      Left            =   90
      Top             =   540
   End
   Begin VB.TextBox txtDolniLista 
      Appearance      =   0  'Flat
      BackColor       =   &H00000000&
      BorderStyle     =   0  'None
      BeginProperty Font 
         Name            =   "Tahoma"
         Size            =   8.25
         Charset         =   238
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00404040&
      Height          =   225
      Left            =   60
      TabIndex        =   20
      TabStop         =   0   'False
      Text            =   "2003 © Manicsoft, Matìj Šimek [Enzy]    matej.simek@cmail.cz"
      Top             =   7830
      Width           =   4515
   End
   Begin VB.Timer trmtvujstav 
      Interval        =   100
      Left            =   4530
      Top             =   510
   End
   Begin VB.Frame frmStatistiky 
      BackColor       =   &H00000000&
      Caption         =   " Statistiky "
      ForeColor       =   &H00808080&
      Height          =   945
      Left            =   75
      TabIndex        =   13
      Top             =   5760
      Visible         =   0   'False
      Width           =   4515
      Begin VB.Label Stat_pcZasahlLodi 
         AutoSize        =   -1  'True
         BackStyle       =   0  'Transparent
         Caption         =   "Poèítaè vám zasáhl lodí:"
         ForeColor       =   &H00808080&
         Height          =   195
         Left            =   2490
         TabIndex        =   19
         Top             =   630
         Width           =   1740
      End
      Begin VB.Line Line4 
         BorderColor     =   &H00808080&
         X1              =   2400
         X2              =   2400
         Y1              =   180
         Y2              =   870
      End
      Begin VB.Label Stat_potopenychLodiPC 
         AutoSize        =   -1  'True
         BackStyle       =   0  'Transparent
         Caption         =   "Zasáhl jste poèítaèi lodí:"
         ForeColor       =   &H00C0C0C0&
         Height          =   195
         Left            =   2490
         TabIndex        =   18
         Top             =   420
         Width           =   1725
      End
      Begin VB.Label Stat_KdoVede 
         AutoSize        =   -1  'True
         BackStyle       =   0  'Transparent
         Caption         =   "Kdo vede: Vy / Poèítaè"
         ForeColor       =   &H00FFFFFF&
         Height          =   195
         Left            =   2490
         TabIndex        =   17
         Top             =   210
         Width           =   1680
      End
      Begin VB.Label Stat_ZbyvaTahu 
         AutoSize        =   -1  'True
         BackStyle       =   0  'Transparent
         Caption         =   "Zbývá vám maximálnì tahù: 49"
         ForeColor       =   &H00C0C000&
         Height          =   195
         Left            =   120
         TabIndex        =   16
         Top             =   630
         Width           =   2205
      End
      Begin VB.Label Stat_zbyvaLodiPC 
         AutoSize        =   -1  'True
         BackColor       =   &H00000000&
         BackStyle       =   0  'Transparent
         Caption         =   "Poèítaèi zbývá lodí: 6"
         ForeColor       =   &H00FFFF00&
         Height          =   195
         Left            =   120
         TabIndex        =   15
         Top             =   420
         Width           =   1530
      End
      Begin VB.Label Stat_ZbyvaMychLodi 
         AutoSize        =   -1  'True
         BackColor       =   &H00000000&
         BackStyle       =   0  'Transparent
         Caption         =   "Zbývá vám lodí: 6"
         ForeColor       =   &H00FFFFC0&
         Height          =   195
         Left            =   120
         TabIndex        =   14
         Top             =   210
         Width           =   1275
      End
   End
   Begin VB.Frame Frame1 
      Appearance      =   0  'Flat
      BackColor       =   &H00000000&
      BorderStyle     =   0  'None
      ForeColor       =   &H00FFFFFF&
      Height          =   4635
      Left            =   0
      TabIndex        =   12
      Top             =   1080
      Width           =   4665
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   0
         Left            =   270
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   1
         Left            =   870
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   2
         Left            =   1470
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   3
         Left            =   2070
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   4
         Left            =   2670
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   5
         Left            =   3270
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   6
         Left            =   3870
         Top             =   240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   7
         Left            =   270
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   8
         Left            =   870
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   9
         Left            =   1470
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   10
         Left            =   2070
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   11
         Left            =   2670
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   12
         Left            =   3270
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   13
         Left            =   3870
         Top             =   840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   14
         Left            =   270
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   15
         Left            =   870
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   16
         Left            =   1470
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   17
         Left            =   2070
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   18
         Left            =   2670
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   19
         Left            =   3270
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   20
         Left            =   3870
         Top             =   1440
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   21
         Left            =   270
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   22
         Left            =   870
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   23
         Left            =   1470
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   24
         Left            =   2070
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   25
         Left            =   2670
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   26
         Left            =   3270
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   27
         Left            =   3870
         Top             =   2040
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   28
         Left            =   270
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   29
         Left            =   870
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   30
         Left            =   1470
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   31
         Left            =   2070
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   32
         Left            =   2670
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   33
         Left            =   3270
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   34
         Left            =   3870
         Top             =   2640
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   35
         Left            =   270
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   36
         Left            =   870
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   37
         Left            =   1470
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   38
         Left            =   2070
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   39
         Left            =   2670
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   40
         Left            =   3270
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   41
         Left            =   3870
         Top             =   3240
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   42
         Left            =   270
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   43
         Left            =   870
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   44
         Left            =   1470
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   45
         Left            =   2070
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   46
         Left            =   2670
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   47
         Left            =   3270
         Top             =   3840
         Width           =   480
      End
      Begin VB.Image pol 
         Appearance      =   0  'Flat
         Height          =   480
         Index           =   48
         Left            =   3870
         Top             =   3840
         Width           =   480
      End
      Begin VB.Line Line3 
         BorderColor     =   &H00FFC0C0&
         Index           =   5
         X1              =   270
         X2              =   4350
         Y1              =   3780
         Y2              =   3780
      End
      Begin VB.Line Line3 
         BorderColor     =   &H00FFC0C0&
         Index           =   4
         X1              =   270
         X2              =   4350
         Y1              =   3180
         Y2              =   3180
      End
      Begin VB.Line Line3 
         BorderColor     =   &H00FFC0C0&
         Index           =   3
         X1              =   270
         X2              =   4350
         Y1              =   2580
         Y2              =   2580
      End
      Begin VB.Line Line3 
         BorderColor     =   &H00FFC0C0&
         Index           =   2
         X1              =   270
         X2              =   4350
         Y1              =   1980
         Y2              =   1980
      End
      Begin VB.Line Line3 
         BorderColor     =   &H00FFC0C0&
         Index           =   1
         X1              =   270
         X2              =   4350
         Y1              =   1380
         Y2              =   1380
      End
      Begin VB.Line Line3 
         BorderColor     =   &H00FFC0C0&
         Index           =   6
         X1              =   270
         X2              =   4350
         Y1              =   780
         Y2              =   780
      End
      Begin VB.Line Line2 
         BorderColor     =   &H00FFC0C0&
         Index           =   5
         X1              =   3810
         X2              =   3810
         Y1              =   240
         Y2              =   4320
      End
      Begin VB.Line Line2 
         BorderColor     =   &H00FFC0C0&
         Index           =   4
         X1              =   3210
         X2              =   3210
         Y1              =   240
         Y2              =   4320
      End
      Begin VB.Line Line2 
         BorderColor     =   &H00FFC0C0&
         Index           =   3
         X1              =   2610
         X2              =   2610
         Y1              =   240
         Y2              =   4320
      End
      Begin VB.Line Line2 
         BorderColor     =   &H00FFC0C0&
         Index           =   2
         X1              =   2010
         X2              =   2010
         Y1              =   240
         Y2              =   4320
      End
      Begin VB.Line Line2 
         BorderColor     =   &H00FFC0C0&
         Index           =   1
         X1              =   1410
         X2              =   1410
         Y1              =   240
         Y2              =   4320
      End
      Begin VB.Line Line2 
         BorderColor     =   &H00FFC0C0&
         Index           =   0
         X1              =   810
         X2              =   810
         Y1              =   240
         Y2              =   4320
      End
      Begin VB.Line Vlna 
         BorderColor     =   &H00FF8080&
         Index           =   8
         X1              =   480
         X2              =   480
         Y1              =   3900
         Y2              =   4170
      End
      Begin VB.Line Vlna 
         BorderColor     =   &H00FFC0C0&
         Index           =   7
         X1              =   4140
         X2              =   4140
         Y1              =   3630
         Y2              =   3900
      End
      Begin VB.Line Vlna 
         BorderColor     =   &H00FF8080&
         Index           =   6
         X1              =   3480
         X2              =   3480
         Y1              =   2100
         Y2              =   2370
      End
      Begin VB.Line Vlna 
         BorderColor     =   &H00FF8080&
         Index           =   5
         X1              =   2850
         X2              =   2850
         Y1              =   990
         Y2              =   1260
      End
      Begin VB.Line Vlna 
         BorderColor     =   &H00FF8080&
         Index           =   4
         X1              =   2310
         X2              =   2310
         Y1              =   330
         Y2              =   600
      End
      Begin VB.Line Vlna 
         BorderColor     =   &H00FF8080&
         Index           =   3
         X1              =   2190
         X2              =   2190
         Y1              =   3330
         Y2              =   3600
      End
      Begin VB.Line Vlna 
         BorderColor     =   &H00FF8080&
         Index           =   2
         X1              =   990
         X2              =   990
         Y1              =   2730
         Y2              =   3000
      End
      Begin VB.Line Vlna 
         BorderColor     =   &H00FF8080&
         Index           =   1
         X1              =   1620
         X2              =   1620
         Y1              =   1500
         Y2              =   1770
      End
      Begin VB.Line Vlna 
         BorderColor     =   &H00FF8080&
         Index           =   0
         X1              =   180
         X2              =   180
         Y1              =   210
         Y2              =   480
      End
      Begin VB.Image imgPozadi1 
         Enabled         =   0   'False
         Height          =   4500
         Left            =   90
         Picture         =   "Form1.frx":3FAA
         Top             =   60
         Width           =   4500
      End
   End
   Begin VB.Timer tmrNovaHra 
      Enabled         =   0   'False
      Interval        =   1
      Left            =   4650
      Top             =   -270
   End
   Begin VB.CommandButton cmdKonec 
      BackColor       =   &H00000000&
      Cancel          =   -1  'True
      Height          =   945
      Left            =   75
      Picture         =   "Form1.frx":7FAA
      Style           =   1  'Graphical
      TabIndex        =   4
      Top             =   6810
      Width           =   4515
   End
   Begin VB.CommandButton cmdNovaHra 
      BackColor       =   &H00000000&
      Default         =   -1  'True
      Height          =   945
      Left            =   60
      Picture         =   "Form1.frx":8FA2
      Style           =   1  'Graphical
      TabIndex        =   3
      Top             =   5790
      Width           =   4545
   End
   Begin VB.PictureBox vzorLod 
      Height          =   555
      Left            =   2940
      Picture         =   "Form1.frx":9FB8
      ScaleHeight     =   495
      ScaleWidth      =   495
      TabIndex        =   0
      Top             =   -480
      Visible         =   0   'False
      Width           =   555
   End
   Begin VB.PictureBox vzorDira 
      Height          =   555
      Left            =   3510
      Picture         =   "Form1.frx":A455
      ScaleHeight     =   495
      ScaleWidth      =   495
      TabIndex        =   1
      Top             =   -480
      Visible         =   0   'False
      Width           =   555
   End
   Begin VB.PictureBox vzorOtaz 
      Height          =   555
      Left            =   4050
      Picture         =   "Form1.frx":A916
      ScaleHeight     =   495
      ScaleWidth      =   495
      TabIndex        =   2
      Top             =   -480
      Visible         =   0   'False
      Width           =   555
   End
   Begin VB.Line Line3 
      BorderColor     =   &H00FFFFFF&
      Index           =   0
      X1              =   -4
      X2              =   312
      Y1              =   70
      Y2              =   70
   End
   Begin VB.Label TypHry 
      BackColor       =   &H00000000&
      Height          =   15
      Left            =   4680
      TabIndex        =   11
      Top             =   60
      Visible         =   0   'False
      Width           =   15
   End
   Begin VB.Line Line1 
      BorderColor     =   &H00FFFFFF&
      X1              =   0
      X2              =   312
      Y1              =   382
      Y2              =   382
   End
   Begin VB.Label lblMojeLod 
      BackColor       =   &H00000000&
      BackStyle       =   0  'Transparent
      Height          =   225
      Index           =   5
      Left            =   1230
      TabIndex        =   10
      Top             =   420
      Visible         =   0   'False
      Width           =   225
   End
   Begin VB.Label lblMojeLod 
      BackColor       =   &H00000000&
      BackStyle       =   0  'Transparent
      Height          =   225
      Index           =   4
      Left            =   -60
      TabIndex        =   9
      Top             =   930
      Visible         =   0   'False
      Width           =   225
   End
   Begin VB.Label lblMojeLod 
      BackColor       =   &H00000000&
      BackStyle       =   0  'Transparent
      Height          =   225
      Index           =   3
      Left            =   720
      TabIndex        =   8
      Top             =   1080
      Visible         =   0   'False
      Width           =   225
   End
   Begin VB.Label lblMojeLod 
      BackColor       =   &H00000000&
      BackStyle       =   0  'Transparent
      Height          =   225
      Index           =   2
      Left            =   420
      TabIndex        =   7
      Top             =   420
      Visible         =   0   'False
      Width           =   225
   End
   Begin VB.Label lblMojeLod 
      BackColor       =   &H00000000&
      BackStyle       =   0  'Transparent
      Height          =   225
      Index           =   1
      Left            =   180
      TabIndex        =   6
      Top             =   420
      Visible         =   0   'False
      Width           =   225
   End
   Begin VB.Label lblMojeLod 
      BackColor       =   &H00000000&
      BackStyle       =   0  'Transparent
      Height          =   225
      Index           =   6
      Left            =   0
      TabIndex        =   5
      Top             =   420
      Visible         =   0   'False
      Width           =   225
   End
   Begin VB.Image Image1 
      Height          =   900
      Left            =   90
      Picture         =   "Form1.frx":AD93
      Top             =   30
      Width           =   4500
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim Typ As Byte, PolickoIndex As Byte, pcTah As Byte, pocetTahuPc As Byte, objevenychLodi As Byte, PCobjevenychLodi As Byte, ZbyvaMaxTahu As Byte
Dim MojeLode(6) As Byte
Dim PC(6) As Byte
Dim UdelaneTahyPC(48)

Private Sub cmdNovaHra_Click()
    Unload Me
    Form2.Show
End Sub

Private Sub cmdKonec_Click()
If TypHry.Visible = False Then
    Me.WindowState = 1
    End
Else
    Call KonecHry("konec")
End If
End Sub

Private Sub SpusteniHry()
'nastaveni obrazku otazniku na všechny políèka
For i = 0 To 48
 pol(i).Picture = vzorOtaz.Picture
Next i
'pøevod do prommìné z labelu
For i = 1 To 6
    MojeLode(i) = lblMojeLod(i)
Next i
'povolení všech políèek
For i = 0 To 48
    pol(i).Enabled = True
Next i
'vygenerování políèek poèítaèe
For i = 1 To 6
    Randomize
    a = Int(Rnd * 48)
    'opakuj vygenerování náhodného èísla tak dlouho až pc(1) až pc(6) se nebudou rovnat
    Do
        Do Until a <> PC(1) And a <> PC(2) And a <> PC(3) And a <> PC(4) And a <> PC(5) And a <> PC(6)
            a = Int(Rnd * 48)
        Loop
    Loop Until a <> PC(1) And a <> PC(2) And a <> PC(3) And a <> PC(4) And a <> PC(5) And a <> PC(6)
    PC(i) = a
Next i

For i = 0 To 48
    Form4.pol(i).Picture = vzorOtaz.Picture
Next i

For i = 1 To 6
    l = MojeLode(i)
    Form4.pol(l).Picture = vzorLod.Picture
Next i
Form4.Show

pocetTahuPc = 0
objevenychLodi = 0
PCobjevenychLodi = 0

frmStatistiky.Visible = True

ZbyvaMaxTahu = 0
'pouze pro kontrolu
'For i = 1 To 6
'    Print PC(i)
'Next i
End Sub

Private Sub Form_Load()
Randomize
For i = 0 To 48
    Typ = Int(Rnd * 3)
    Select Case Typ
    Case 0
        pol(i).Picture = vzorLod.Picture
    Case 1
        pol(i).Picture = vzorDira.Picture
    Case 2
        pol(i).Picture = vzorOtaz.Picture
    End Select
Next i
For i = 0 To 48
    pol(i).Enabled = False
Next i


End Sub

Private Sub Form_Unload(Cancel As Integer)
    Unload Form2
    Unload Form4
    Unload Form5
End Sub

Private Sub pol_Click(Index As Integer)
PolickoIndex = Index

If TypHry.Visible = True Then
    If pol(PolickoIndex).Picture <> Me.Picture And pol(PolickoIndex).Picture <> vzorDira.Picture Then
        For i = 1 To 6
            If PC(i) = PolickoIndex Then
                pol(PolickoIndex).Picture = vzorDira.Picture
                objevenychLodi = objevenychLodi + 1
                Call overeniVyhry
                Exit For
            Else
                pol(PolickoIndex).Picture = Me.Picture
                Call overeniVyhry
            End If
        Next i
        ZbyvaMaxTahu = ZbyvaMaxTahu + 1
        Call TahPocitace
    End If
ElseIf TypHry.Visible = False Then
    End
End If

End Sub
Private Sub TahPocitace()
Randomize
pcTah = 0
pcTah = Int(Rnd * 48)
If Form4.pol(pcTah).Picture <> Me.Picture And Form4.pol(pcTah).Picture <> vzorDira.Picture Then
        For i = 1 To 6
            If pcTah = MojeLode(i) Then
                Form4.pol(pcTah).Picture = vzorDira.Picture
                pocetTahuPc = pocetTahuPc + 1
                PCobjevenychLodi = PCobjevenychLodi + 1
                Call overeniVyhry
                Exit For
            End If
        Next i
        
        If Form4.pol(pcTah).Picture = vzorOtaz.Picture Then
            Form4.pol(pcTah).Picture = Me.Picture
            pocetTahuPc = pocetTahuPc + 1
            Call overeniVyhry
        End If
Else '_____________________________________________________________________________________________________________________________
     '-------------- opakuj dokud --------------------
    Do
        Do Until Form4.pol(pcTah).Picture <> Me.Picture And Form4.pol(pcTah).Picture <> vzorDira.Picture And pcTah <> 49
            pcTah = Int(Rnd * 49)
            If pocetTahuPc = 49 Then Exit Do
        Loop
        If pocetTahuPc = 49 Then Exit Do
    Loop Until Form4.pol(pcTah).Picture <> Me.Picture And Form4.pol(pcTah).Picture <> vzorDira.Picture And pcTah <> 49
    
    '----potom udìlej-----------------------------------------------------------------------------------
    If Form4.pol(pcTah).Picture <> Me.Picture And Form4.pol(pcTah).Picture <> vzorDira.Picture Then
        For i = 1 To 6
            If pcTah = MojeLode(i) Then
                Form4.pol(pcTah).Picture = vzorDira.Picture
                pocetTahuPc = pocetTahuPc + 1
                PCobjevenychLodi = PCobjevenychLodi + 1
                Call overeniVyhry
                Exit For
            End If
        Next i
        
        If Form4.pol(pcTah).Picture = vzorOtaz.Picture Then
            Form4.pol(pcTah).Picture = Me.Picture
            pocetTahuPc = pocetTahuPc + 1
            Call overeniVyhry
        End If
    End If
    
End If
End Sub

Private Sub overeniVyhry()
    If objevenychLodi = 6 Then
        Call KonecHry("hum")
    ElseIf PCobjevenychLodi = 6 Then
        Call KonecHry("pc")
    End If
    
Stat_potopenychLodiPC.Caption = "Zasáhl jste poèítaèi lodí: " & objevenychLodi
Stat_pcZasahlLodi.Caption = "Poèítaè vám zasáhl lodí: " & PCobjevenychLodi
If objevenychLodi > PCobjevenychLodi Then
    Stat_KdoVede.Caption = "Kdo vede: Vy"
ElseIf objevenychLodi < PCobjevenychLodi Then
    Stat_KdoVede.Caption = "Kdo vede: Poèítaè"
ElseIf objevenychLodi = PCobjevenychLodi Then
    Stat_KdoVede.Caption = "Kdo vede: Nerozhodnì"
End If

Stat_ZbyvaMychLodi.Caption = "Zbývá vám lodí: " & 6 - PCobjevenychLodi
Stat_zbyvaLodiPC.Caption = "Poèítaèi zbývá lodí: " & 6 - objevenychLodi

Stat_ZbyvaTahu.Caption = "Zbývá vám maximálnì tahù: " & 49 - ZbyvaMaxTahu
End Sub

Private Sub KonecHry(kdo_vyhral)
'____ Vynulování ____________________________

Call Form_Load

For i = 1 To 6
    MojeLode(i) = 0
Next i
'zakázání všech políèek
For i = 0 To 48
    pol(i).Enabled = False
Next i
For i = 1 To 6
    PC(i) = 0
Next i
For i = 1 To 6
    MojeLode(i) = 0
Next i
Form4.Hide
pocetTahuPc = 0
objevenychLodi = 0
PCobjevenychLodi = 0
ZbyvaMaxTahu = 0

cmdNovaHra.Visible = True
TypHry.Visible = False

For i = 1 To 6
    lblMojeLod(i).Caption = ""
Next i

For i = 1 To 6
    MojeLode(i) = 0
Next i

For i = 0 To 48
    If pol(i).BorderStyle = 1 Then pol(i).BorderStyle = 0
Next i

frmStatistiky.Visible = False

'___ Ukázání výhry ___________________________

If kdo_vyhral = "pc" Then
    Form5.cmd1.Picture = Form5.PC.Picture
    Form5.Show 1
ElseIf kdo_vyhral = "hum" Then
    Form5.cmd1.Picture = Form5.Hum.Picture
    Form5.Show 1
ElseIf kdo_vyhral = "konec" Then
    Exit Sub
End If
End Sub

Private Sub pol_MouseMove(Index As Integer, Button As Integer, Shift As Integer, X As Single, Y As Single)
For i = 0 To 48
    If pol(i).BorderStyle = 1 And i <> Index Then pol(i).BorderStyle = 0
Next i
If pol(Index).BorderStyle = 0 Then pol(Index).BorderStyle = 1
End Sub

Private Sub tmrAnimaceVln_Timer()
For i = 0 To 7
    If Vlna(i).Y1 < 4500 Then
        Vlna(i).Y1 = Vlna(i).Y1 + 50
        Vlna(i).Y2 = Vlna(i).Y2 + 50
    ElseIf Vlna(i).Y2 >= 4500 Then
        Vlna(i).Y1 = 0
        Vlna(i).Y2 = 270
    End If
Next i
End Sub

Private Sub tmrNovaHra_Timer()
Call SpusteniHry
tmrNovaHra.Enabled = False
End Sub

Private Sub trmtvujstav_Timer()
If Form4.Visible = True Then
    Form4.Left = Form1.Left + Form1.Width + 100
    Form4.Top = Form1.Top
End If
End Sub
