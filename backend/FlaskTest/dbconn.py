import cx_Oracle

def db_connect() :
    dns = cx_Oracle.makedsn('127.0.0.1', 1521, 'xe')
    conn = cx_Oracle.connect('kb_db', '1234', dns)
    return conn

def db_close(conn) :
    conn.close()