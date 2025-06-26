import requests

def envoyer_sms(num_tel, message) -> dict:
    """
    Envoie un SMS via l'API AllMySMS.
 
   
    
    
    :param api_key: Votre clé API GetAllMySMS
    :param numero: Numéro de téléphone du destinataire (ex: "33612345678")
    :param message: Message à envoyer
    :return: Dictionnaire contenant la réponse de l'API
    """
    
url = "https://api.allmysms.com/sms/send"
payload = "{\r\n    \"from\": \"allmysms\",\r\n    \"to\": \"33612345678\",\r\n    \"text\": \"Hello this is a test SMS FROM REST API\\r\\nStop au 36180\"\r\n}"

headers = {
    'Content-Type': "application/json",
    'Authorization': "Basic AUTH_TOKEN",
    'cache-control': "no-cache"
    }

response = requests.request("POST", url, data=payload, headers=headers)
print(response.text)

