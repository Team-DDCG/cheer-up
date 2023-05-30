import pandas
from mailmerge import MailMerge
import json

excel_data_fragment = pandas.read_excel("C:/kb/cheer-up_portfoliio/real_fin_KB/ver3_new_excel_testing_reference/info.xlsx")
print(excel_data_fragment)
excel_data_fragment['numbers'] = excel_data_fragment['numbers'].astype(str)  # converted to string as it interferes with

# the code if it is an integer
json_str = excel_data_fragment.to_json(orient='records')
columns = json_str.replace("\\u00a0", "")


# Getting rid of empty cells if any
columns = json.dumps(columns)
columns = json.loads(columns)
array = '{"columns": %s}' % columns
data = json.loads(array)


# Loading .docx file
template = "C:/kb/cheer-up_portfoliio/real_fin_KB/ver3_new_excel_testing_reference/portfolio_test_alpha.docx"
document = MailMerge(template)

# Merging the data
document.merge_rows('numbers', data['columns'])
document.merge_rows('alphabets', data['columns'])
document.write("C:/kb/cheer-up_portfoliio/real_fin_KB/ver3_new_excel_testing_reference/portfolio_test_alpha_after.docx")
