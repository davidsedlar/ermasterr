package org.insightech.er.editor.view.dialog.element.table.sub;

import java.math.BigDecimal;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.insightech.er.common.dialog.AbstractDialog;
import org.insightech.er.common.exception.InputException;
import org.insightech.er.common.widgets.CompositeFactory;
import org.insightech.er.db.impl.postgres.PostgresDBManager;
import org.insightech.er.editor.model.diagram_contents.not_element.sequence.Sequence;
import org.insightech.er.util.Format;

public class AutoIncrementSettingDialog extends AbstractDialog {

    private Text incrementText;

    private Text minValueText;

    private Text maxValueText;

    private Text startText;

    private Text cacheText;

    private Button cycleCheckBox;

    private final Sequence sequence;

    private Sequence result;

    private final String database;

    public AutoIncrementSettingDialog(final Shell parentShell, final Sequence sequence, final String database) {
        super(parentShell);

        this.sequence = sequence;
        this.database = database;
    }

    @Override
    protected void initialize(final Composite composite) {
        incrementText = CompositeFactory.createNumText(this, composite, "Increment", true);

        if (PostgresDBManager.ID.equals(database)) {
            minValueText = CompositeFactory.createNumText(this, composite, "MinValue", true);
            maxValueText = CompositeFactory.createNumText(this, composite, "MaxValue", true);
        }

        startText = CompositeFactory.createNumText(this, composite, "Start", true);

        if (PostgresDBManager.ID.equals(database)) {
            cacheText = CompositeFactory.createNumText(this, composite, "Cache", true);
            cycleCheckBox = CompositeFactory.createCheckbox(this, composite, "Cycle", false, 2);
        }
    }

    @Override
    protected String getErrorMessage() {
        String text = incrementText.getText();

        if (!text.equals("")) {
            try {
                Integer.parseInt(text);

            } catch (final NumberFormatException e) {
                return "error.sequence.increment.degit";
            }
        }

        if (minValueText != null) {
            text = minValueText.getText();

            if (!text.equals("")) {
                try {
                    Long.parseLong(text);

                } catch (final NumberFormatException e) {
                    return "error.sequence.minValue.degit";
                }
            }
        }

        if (maxValueText != null) {
            text = maxValueText.getText();

            if (!text.equals("")) {
                try {
                    new BigDecimal(text);

                } catch (final NumberFormatException e) {
                    return "error.sequence.maxValue.degit";
                }
            }
        }

        text = startText.getText();

        if (!text.equals("")) {
            try {
                Long.parseLong(text);

            } catch (final NumberFormatException e) {
                return "error.sequence.start.degit";
            }
        }

        if (cacheText != null) {
            text = cacheText.getText();

            if (!text.equals("")) {
                try {
                    Integer.parseInt(text);

                } catch (final NumberFormatException e) {
                    return "error.sequence.cache.degit";
                }
            }
        }

        return null;
    }

    @Override
    protected String getTitle() {
        return "label.auto.increment.setting";
    }

    @Override
    protected void perfomeOK() throws InputException {
        result = new Sequence();

        Integer increment = null;
        Long minValue = null;
        BigDecimal maxValue = null;
        Long start = null;
        Integer cache = null;

        String text = incrementText.getText();
        if (!text.equals("")) {
            increment = Integer.valueOf(text);
        }

        if (minValueText != null) {
            text = minValueText.getText();
            if (!text.equals("")) {
                minValue = Long.valueOf(text);
            }
        }

        if (maxValueText != null) {
            text = maxValueText.getText();
            if (!text.equals("")) {
                maxValue = new BigDecimal(text);
            }
        }

        text = startText.getText();
        if (!text.equals("")) {
            start = Long.valueOf(text);
        }

        if (cacheText != null) {
            text = cacheText.getText();
            if (!text.equals("")) {
                cache = Integer.valueOf(text);
            }
        }

        result.setIncrement(increment);
        result.setMinValue(minValue);
        result.setMaxValue(maxValue);
        result.setStart(start);
        result.setCache(cache);

        if (cycleCheckBox != null) {
            result.setCycle(cycleCheckBox.getSelection());
        }
    }

    @Override
    protected void setData() {
        if (sequence != null) {
            incrementText.setText(Format.toString(sequence.getIncrement()));
            if (minValueText != null) {
                minValueText.setText(Format.toString(sequence.getMinValue()));
            }
            if (maxValueText != null) {
                maxValueText.setText(Format.toString(sequence.getMaxValue()));
            }
            startText.setText(Format.toString(sequence.getStart()));
            if (maxValueText != null) {
                cacheText.setText(Format.toString(sequence.getCache()));
            }
            if (cycleCheckBox != null) {
                cycleCheckBox.setSelection(sequence.isCycle());
            }
        }
    }

    public Sequence getResult() {
        return result;
    }

}
