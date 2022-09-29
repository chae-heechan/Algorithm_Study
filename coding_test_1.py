import spacy

nlp = spacy.load("en_core_web_sm")


def anonymize_text(sentences):
    answer = ""
    words = nlp(sentences)

    for word in words:
        if word.tag_ == "NNP":
            print("aaa")
        answer += word.tag_ + " "

    return answer


anonymize_text("John ate an apple Oh John")
