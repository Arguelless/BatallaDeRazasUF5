<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/battle">
   <html>
        <head>
            <meta charset="UTF-8"/>
            <link href="./estils.css" rel="stylesheet"/>
            <title>Battle History</title>
        </head>
        <body>
            <h1>Battle History</h1>
            <table>
        <thead>
        <tr>
            <th>Battle ID</th>
            <th>Player ID</th>
            <th>Warrior ID</th>
            <th>Warrior weapon ID</th>
            <th>Opponent ID</th>
            <th>Opponent weapon ID</th>
            <th>Injuries caused</th>
            <th>Injuries suffered</th>
            <th>Battle points</th>
        </tr>
        </thead>
        <tbody>
        <xsl:for-each select="/battle/registro">
            <tr>
            <td><xsl:value-of select="battle_id"/></td>
            <td><xsl:value-of select="player_id"/></td>
            <td><xsl:value-of select="warrior_id"/></td>
            <td><xsl:value-of select="warrior_weapon_id"/></td>
            <td><xsl:value-of select="opponent_id"/></td>
            <td><xsl:value-of select="opponent_weapon_id"/></td>
            <td><xsl:value-of select="injuries_caused"/></td>
            <td><xsl:value-of select="injuries_suffered"/></td>
            <td><xsl:value-of select="battle_points"/></td>

            </tr>
        </xsl:for-each>
        </tbody>
        </table>
        </body>
   
   
   </html>
   
   
   
   
</xsl:template>
</xsl:stylesheet>