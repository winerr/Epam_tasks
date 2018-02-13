<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
    <html>
        <head></head>
        <body>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Origin</th>
                    <th>Price</th>
                </tr>
                <xsl:for-each select="devices/device">
                    <tr>
                        <td><xsl:value-of select="name"/></td>
                        <td><xsl:value-of select="origin"/></td>
                        <td><xsl:value-of select="price"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>