package br.com.ultimate.controller;

import com.google.gson.Gson;
import org.json.JSONObject;

/**
 * Created by Gustavo on 20/06/2017.
 * Interface responsável por armazenar
 */
public interface IController {

    Gson gson = new Gson();

    JSONObject json = new JSONObject();
}
