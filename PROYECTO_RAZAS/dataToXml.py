import mysql.connector
from mysql.connector import Error
import xml.etree.ElementTree as ET


# Establecer la conexión con la base de datos
try:
    connection = mysql.connector.connect(
        host='localhost',
        database='bddbatalla',
        user='root',
        password='1234'
    )

    # Obtener los datos de una tabla específica
    cursor = connection.cursor()
    cursor.execute('SELECT * FROM battle')
    rows = cursor.fetchall()

    # Cerrar la conexión con la base de datos
    connection.close()

except Error as e:
    print('Error al conectarse a la base de datos:', e)




# Crear el elemento raíz del archivo XML
root = ET.Element('battle')

# Agregar los datos de la tabla al archivo XML
for row in rows:
    registro = ET.SubElement(root, 'registro')
    for i, column in enumerate(row):
        nombre_columna = cursor.description[i][0]
        valor_columna = str(column)
        columna = ET.SubElement(registro, nombre_columna)
        columna.text = valor_columna

# Guardar el archivo XML
tree = ET.ElementTree(root)
tree.write('./PROYECTO_RAZAS/xml/battle.xml', encoding='utf-8', xml_declaration=True)

cursor.close()