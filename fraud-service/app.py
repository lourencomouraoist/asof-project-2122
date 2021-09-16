import json
import sys

sys.path.append('fraud_graph/')
import create_dataset2 as create_dataset
import get_scores as get_scores
import fraud_times.quiz_orm as quiz_orm
import fraud_times.quiz_statistics as quiz_stats
from dotenv import load_dotenv
import os
from flask import Flask, Response
from pathlib import Path

# Does not override env vars, so docker-compose shall set env vars if run. Otherwise, sets env vars from .env file
load_dotenv() 
app = Flask(__name__)


@app.route('/quiz/<quizId>')
def quizFraudScores(quizId):
    dbConnector = quiz_orm.QuizzesDBConnector()
    quiz = dbConnector.get_quiz(quizId)
    statistic = quiz_stats.Quiz_Statistic(
        quiz, quiz_stats.QUIZ_SCORERS["Diff. Mean (Question ID)"])
    result = [{"username": k, "score": v}
              for k, v in statistic.statistic.items()]
    return Response(json.dumps(result), mimetype="application/json")


@app.route('/graph/quiz/<quizId>')
def quizFraudScoresGraph(quizId):
    data = create_dataset.create_dataset(quizId, "*")
    scores_in, scores_out = get_scores.create_network("All", data, True, True, 2)
    print(scores_in)
    print(scores_out)
    scores_in = [{"username": k, "score": v}
                 for k, v in scores_in.items()]
    scores_out = [{"username": k, "score": v}
                  for k, v in scores_out.items()]
    return Response(json.dumps({"scoresIn": scores_in, "scoresOut": scores_out}), mimetype="application/json")