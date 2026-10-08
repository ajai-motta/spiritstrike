package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: KeyMapping.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001f\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0000ø\u0001\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"defaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "commonKeyMapping", "shortcutModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    public static final KeyMapping commonKeyMapping(final Function1<? super KeyEvent, Boolean> shortcutModifier) {
        Intrinsics.checkNotNullParameter(shortcutModifier, "shortcutModifier");
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt.commonKeyMapping.1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo711mapZmokQxo(android.view.KeyEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (shortcutModifier.invoke(KeyEvent.m2870boximpl(event)).booleanValue() && KeyEvent_androidKt.m2893isShiftPressedZmokQxo(event)) {
                    if (Key.m2292equalsimpl0(KeyEvent_androidKt.m2887getKeyZmokQxo(event), MappedKeys.INSTANCE.m744getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (shortcutModifier.invoke(KeyEvent.m2870boximpl(event)).booleanValue()) {
                    long jM2887getKeyZmokQxo = KeyEvent_androidKt.m2887getKeyZmokQxo(event);
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo, MappedKeys.INSTANCE.m726getCEK5gGoQ()) || Key.m2292equalsimpl0(jM2887getKeyZmokQxo, MappedKeys.INSTANCE.m735getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo, MappedKeys.INSTANCE.m742getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo, MappedKeys.INSTANCE.m743getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo, MappedKeys.INSTANCE.m723getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo, MappedKeys.INSTANCE.m744getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.m2891isCtrlPressedZmokQxo(event)) {
                    return null;
                }
                if (KeyEvent_androidKt.m2893isShiftPressedZmokQxo(event)) {
                    long jM2887getKeyZmokQxo2 = KeyEvent_androidKt.m2887getKeyZmokQxo(event);
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m730getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m731getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m732getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m729getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m739getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m738getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m737getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m736getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m735getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long jM2887getKeyZmokQxo3 = KeyEvent_androidKt.m2887getKeyZmokQxo(event);
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m730getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m731getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m732getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m729getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m739getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m738getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m737getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m736getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m733getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m725getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m728getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m740getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m727getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m741getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }

    static {
        final KeyMapping keyMappingCommonKeyMapping = commonKeyMapping(new PropertyReference1Impl() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m2891isCtrlPressedZmokQxo(((KeyEvent) obj).m2876unboximpl()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo711mapZmokQxo(android.view.KeyEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m2893isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m2891isCtrlPressedZmokQxo(event)) {
                    long jM2887getKeyZmokQxo = KeyEvent_androidKt.m2887getKeyZmokQxo(event);
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo, MappedKeys.INSTANCE.m730getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo, MappedKeys.INSTANCE.m731getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo, MappedKeys.INSTANCE.m732getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo, MappedKeys.INSTANCE.m729getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m2891isCtrlPressedZmokQxo(event)) {
                    long jM2887getKeyZmokQxo2 = KeyEvent_androidKt.m2887getKeyZmokQxo(event);
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m730getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m731getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m732getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m729getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m734getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m728getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m725getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo2, MappedKeys.INSTANCE.m724getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m2893isShiftPressedZmokQxo(event)) {
                    long jM2887getKeyZmokQxo3 = KeyEvent_androidKt.m2887getKeyZmokQxo(event);
                    if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m737getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_HOME;
                    } else if (Key.m2292equalsimpl0(jM2887getKeyZmokQxo3, MappedKeys.INSTANCE.m736getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_END;
                    }
                }
                return keyCommand == null ? keyMappingCommonKeyMapping.mo711mapZmokQxo(event) : keyCommand;
            }
        };
    }
}
