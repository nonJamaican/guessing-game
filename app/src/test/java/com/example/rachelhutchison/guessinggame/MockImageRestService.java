package com.example.rachelhutchison.guessinggame;

import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

public class MockImageRestService {

    public Answer getSuccessResponse = buildSuccessAnswer();
    public Answer getErrorResponse = buildFailureAnswer();

    public Picasso buildMockRestService(Answer response) {

        Picasso mockPicasso = Mockito.mock(Picasso.class);
        RequestCreator mockRequestCreator = Mockito.mock(RequestCreator.class);
        when(mockPicasso.load(any(String.class))).thenReturn(mockRequestCreator);
        doAnswer(response).when(mockRequestCreator).into(any(ImageView.class), any(Callback.class));
        return mockPicasso;
    }

    private Answer buildSuccessAnswer() {
        return new Answer() {
            public Object answer(InvocationOnMock invocation) {
                Callback callback =
                        (Callback) invocation.getArguments()[1];
                callback.onSuccess();
                return callback;
            }
        };
    }

    private Answer buildFailureAnswer() {
        return new Answer() {
            public Object answer(InvocationOnMock invocation) {
                Callback callback =
                        (Callback) invocation.getArguments()[1];
                callback.onError();
                return callback;
            }
        };
    }
}
