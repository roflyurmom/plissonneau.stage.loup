import requests

import sys
 

def send_sms(sender, recipient, message):

    url = "https://api.allmysms.com/sms/send"

    # Cr�ation du payload avec les param�tres

    payload_dict = {

        "from": sender,

        "to": recipient,

        "text": message

    }

    headers = {

        'Content-Type': "application/json",

        'Authorization': "Basic AUTH_TOKEN",

        'cache-control': "no-cache"

        }

    try:

        # Envoi de la requ�te POST

        response = requests.post(url, json=payload_dict, headers=headers)

        # Affichage de la r�ponse

        print(f"Status Code: {response.status_code}")

        print(f"Response: {response.text}")

        # Retour de la r�ponse

        return {

            "status_code": response.status_code,

            "response": response.text,

            "success": response.status_code == 200

        }

    except requests.exceptions.RequestException as e:

        print(f"Erreur lors de l'envoi du SMS: {e}")

        return {

            "status_code": None,

            "response": str(e),

            "success": False

        }

        # Exemple d'utilisation


if __name__ == "__main__":

    # Exemple 1: Avec les param�tres de base

    sender = sys.argv[1]

    recipient = sys.argv[2]

    message = sys.argv[3]

    result = send_sms(sender, recipient, message)

    print("\n" + "="*150 + "\n")
