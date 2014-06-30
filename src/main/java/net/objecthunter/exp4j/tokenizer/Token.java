/* 
* Copyright 2014 Frank Asseg
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License. 
*/
package net.objecthunter.exp4j.tokenizer;

public abstract class Token {
    public static int TOKEN_NUMBER = 1;
    public static int TOKEN_OPERATOR = 2;
    public static int TOKEN_FUNCTION = 3;
    public static int TOKEN_PARANTHESES = 4;
    public static int TOKEN_VARIABLE = 5;
    protected final int type;

    protected Token(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
