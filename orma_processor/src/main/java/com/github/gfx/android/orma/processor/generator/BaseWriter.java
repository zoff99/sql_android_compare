/*
 * Copyright (c) 2015 FUJI Goro (gfx).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.gfx.android.orma.processor.generator;

import com.github.gfx.android.orma.processor.ProcessingContext;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.util.Optional;

import javax.lang.model.element.Element;

public abstract class BaseWriter {

    protected final ProcessingContext context;

    public BaseWriter(ProcessingContext context) {
        this.context = context;
    }

    public abstract TypeSpec buildTypeSpec();

    public abstract String getPackageName();

    public abstract Optional<? extends Element> getElement();

    public JavaFile buildJavaFile() {
        return JavaFile.builder(getPackageName(), buildTypeSpec())
                .skipJavaLangImports(true)
                .build();
    }
}
